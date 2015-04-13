package com.ctrip.hermes.meta.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.ctrip.hermes.core.utils.PlexusComponentLocator;
import com.ctrip.hermes.meta.entity.Codec;
import com.ctrip.hermes.meta.pojo.CodecView;
import com.ctrip.hermes.meta.server.RestException;
import com.ctrip.hermes.meta.service.CodecService;

@Path("/codecs/")
@Singleton
@Produces(MediaType.APPLICATION_JSON)
public class CodecResource {

	private static CodecService codecService = PlexusComponentLocator.lookup(CodecService.class);

	@GET
	@Path("{name}")
	public CodecView getCodec(@PathParam("name") String name) {
		Codec codec = codecService.getCodec(name);
		if (codec == null) {
			throw new RestException("Codec not found: " + name, Status.NOT_FOUND);
		}
		return new CodecView(codec);
	}

	@GET
	@Path("")
	public List<CodecView> listCodecs() {
		// FIXME hard code two codecs
		List<CodecView> result = new ArrayList<>();
		CodecView jsonCodec = new CodecView();
		jsonCodec.setType("json");
		CodecView avroCodec = new CodecView();
		avroCodec.setType("avro");
		Map<String, Object> configs = new HashMap<>();
		configs.put("schema.registry.url", "http://10.3.8.63:8081");
		avroCodec.setConfig(configs);
		result.add(jsonCodec);
		result.add(avroCodec);
		return result;
	}
}