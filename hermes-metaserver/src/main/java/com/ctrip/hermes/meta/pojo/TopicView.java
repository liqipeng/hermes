package com.ctrip.hermes.meta.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ctrip.hermes.meta.entity.Property;
import com.ctrip.hermes.meta.entity.Topic;

public class TopicView {

	private Long id;

	private String name;

	private String storageType;

	private String description;

	private Map<String, Object> config;

	private String status;

	private Date createTime;

	private Date lastModifiedTime;

	private long schemaId;

	private CodecView codec;

	public TopicView() {

	}

	public TopicView(Topic topic) {
		this.id = topic.getId();
		this.name = topic.getName();
		this.storageType = topic.getStorageType();
		this.description = topic.getDescription();
		this.config = new HashMap<>();
		for (Property property : topic.getProperties()) {
			config.put(property.getName(), property.getValue());
		}
		this.status = topic.getStatus();
		this.createTime = topic.getCreateTime();
		this.lastModifiedTime = topic.getLastModifiedTime();
		this.schemaId = topic.getSchemaId();
		this.codec = new CodecView(topic.getCodec());
	}

	public Map<String, Object> getConfig() {
		return config;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public String getDescription() {
		return description;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public String getName() {
		return name;
	}

	public long getSchemaId() {
		return schemaId;
	}

	public String getStatus() {
		return status;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSchemaId(int schemaId) {
		this.schemaId = schemaId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStorageType(String type) {
		this.storageType = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CodecView getCodec() {
		return codec;
	}

	public void setCodec(CodecView codec) {
		this.codec = codec;
	}

	public Topic toMetaTopic() {
		Topic topic = new Topic();
		topic.setId(this.id);
		topic.setName(this.name);
		topic.setStorageType(this.storageType);
		topic.setDescription(this.description);
		for (Map.Entry<String, Object> entry : this.config.entrySet()) {
			Property prop = new Property();
			prop.setName(entry.getKey());
			prop.setValue(String.valueOf(entry.getValue()));
			topic.addProperty(prop);
		}
		topic.setStatus(this.status);
		topic.setCreateTime(this.createTime);
		topic.setLastModifiedTime(this.lastModifiedTime);
		topic.setSchemaId(this.schemaId);
		topic.setCodec(this.codec.toMetaCodec());
		return topic;
	}
}
