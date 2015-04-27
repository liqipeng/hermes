package com.ctrip.hermes.core.message;

import com.ctrip.hermes.core.result.Callback;

public class ProducerMessage<T> {
	private String m_topic;

	private T m_body;

	private String m_key;

	private boolean m_priority = false;

	private String m_partition;

	private int m_partitionNo;

	private int m_msgSeqNo;

	private long m_bornTime;

	private PropertiesHolder m_propertiesHolder = new PropertiesHolder();

	private Callback callback;

	public ProducerMessage() {

	}

	public ProducerMessage(String m_topic, T m_body) {
		this.m_topic = m_topic;
		this.m_body = m_body;
	}

	public int getMsgSeqNo() {
		return m_msgSeqNo;
	}

	public void setMsgSeqNo(int msgSeqNo) {
		m_msgSeqNo = msgSeqNo;
	}

	public int getPartitionNo() {
		return m_partitionNo;
	}

	public void setPartitionNo(int partitionNo) {
		m_partitionNo = partitionNo;
	}

	public T getBody() {
		return m_body;
	}

	public String getKey() {
		return m_key;
	}

	public String getTopic() {
		return m_topic;
	}

	@SuppressWarnings("unchecked")
	public void setBody(Object object) {
		m_body = (T) object;
	}

	public void setKey(String key) {
		m_key = key;
	}

	public boolean isPriority() {
		return m_priority;
	}

	public void setPriority(boolean priority) {
		m_priority = priority;
	}

	public String getPartition() {
		return m_partition;
	}

	public void setPartition(String partition) {
		m_partition = partition;
	}

	public void setTopic(String topic) {
		m_topic = topic;
	}

	public long getBornTime() {
		return m_bornTime;
	}

	public void setBornTime(long bornTime) {
		m_bornTime = bornTime;
	}

	public PropertiesHolder getPropertiesHolder() {
		return m_propertiesHolder;
	}

	public void setPropertiesHolder(PropertiesHolder propertiesHolder) {
		m_propertiesHolder = propertiesHolder;
	}

	public void addDurableAppProperty(String name, String value) {
		m_propertiesHolder.addDurableAppProperty(name, value);
	}

	public void addDurableSysProperty(String name, String value) {
		m_propertiesHolder.addDurableSysProperty(name, value);
	}

	public String getDurableAppProperty(String name) {
		return m_propertiesHolder.getDurableAppProperty(name);
	}

	public String getDurableSysProperty(String name) {
		return m_propertiesHolder.getDurableSysProperty(name);
	}

	public void addVolatileProperty(String name, String value) {
		m_propertiesHolder.addVolatileProperty(name, value);
	}

	public String getVolatileProperty(String name) {
		return m_propertiesHolder.getVolatileProperty(name);
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	public Callback getCallback() {
		return this.callback;
	}
}
