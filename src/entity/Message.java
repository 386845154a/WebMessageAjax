package entity;

import java.util.Date;

/**
 * ��Ϣʵ��
 * @author Admin
 *
 */
public class Message {
	/**
	 * ��ȡ������
	 * @return
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * ���÷�����
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * ��ȡ������(null����������)
	 * @return
	 */
	public String getReader() {
		return reader;
	}
	
	/**
	 * ���ý�����
	 * @param reader
	 */
	public void setReader(String reader) {
		this.reader = reader;
	}
	
	/**
	 * ��ȡ��Ϣ����
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * ������Ϣ����
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * ��ȡ����ʱ��
	 * @return
	 */
	public Date getSendtime() {
		return sendtime;
	}
	
	/**
	 * ���÷���ʱ��
	 * @param sendtime
	 */
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	private String sender;
	private String reader;
	private String message;
	private Date sendtime;
}
