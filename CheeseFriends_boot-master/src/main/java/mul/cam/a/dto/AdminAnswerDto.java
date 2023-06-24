package mul.cam.a.dto;

public class AdminAnswerDto {
	private int seq;
	private int getQnaSeq;
	private String topic;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	
	public AdminAnswerDto() {
		
	}

	public AdminAnswerDto(int seq, int getQnaSeq, String topic, String title, String writer, String content,
			String regdate) {
		super();
		this.seq = seq;
		this.getQnaSeq = getQnaSeq;
		this.topic = topic;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getGetQnaSeq() {
		return getQnaSeq;
	}

	public void setGetQnaSeq(int getQnaSeq) {
		this.getQnaSeq = getQnaSeq;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AdminAnwerDto [seq=" + seq + ", getQnaSeq=" + getQnaSeq + ", topic=" + topic + ", title=" + title
				+ ", writer=" + writer + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
