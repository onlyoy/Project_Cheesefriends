package mul.cam.a.dto;

import java.io.Serializable;

public class MailDto implements Serializable{
	
	int seq;
	String sender;
	String receiver;
	String title;
	String content;
	String wdate;
	int readcount;
	String filename;
	String newfilename;
	int receivedel;
	String educode;
	int senddel;
	String subcode;
	
	public MailDto() {
		// TODO Auto-generated constructor stub
	}

	public MailDto(int seq, String sender, String receiver, String title, String content, String wdate, int readcount,
			String filename, String newfilename, int receivedel, String educode, int senddel, String subcode) {
		super();
		this.seq = seq;
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.readcount = readcount;
		this.filename = filename;
		this.newfilename = newfilename;
		this.receivedel = receivedel;
		this.educode = educode;
		this.senddel = senddel;
		this.subcode = subcode;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public int getReceivedel() {
		return receivedel;
	}

	public void setReceivedel(int receivedel) {
		this.receivedel = receivedel;
	}

	public String getEducode() {
		return educode;
	}

	public void setEducode(String educode) {
		this.educode = educode;
	}

	public int getSenddel() {
		return senddel;
	}

	public void setSenddel(int senddel) {
		this.senddel = senddel;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	@Override
	public String toString() {
		return "MailDto [seq=" + seq + ", sender=" + sender + ", receiver=" + receiver + ", title=" + title
				+ ", content=" + content + ", wdate=" + wdate + ", readcount=" + readcount + ", filename=" + filename
				+ ", newfilename=" + newfilename + ", receivedel=" + receivedel + ", educode=" + educode + ", senddel="
				+ senddel + ", subcode=" + subcode + "]";
	}

	
	
	

}
