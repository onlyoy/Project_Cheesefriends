package mul.cam.a.dto;

public class AdminQuestionDto {
	private int seq;
	private String topic;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int reply;
	
	public AdminQuestionDto() {
		
	}
	
	public AdminQuestionDto(int seq, String topic, String title, String writer, String content, String regdate,
			int reply) {
		super();
		this.seq = seq;
		this.topic = topic;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.reply = reply;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "AdminQuestionDto [seq=" + seq + ", topic=" + topic + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regdate=" + regdate + ", reply=" + reply + "]";
	}
	
	
}
