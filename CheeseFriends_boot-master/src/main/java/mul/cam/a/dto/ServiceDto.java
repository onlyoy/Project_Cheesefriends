package mul.cam.a.dto;

public class ServiceDto {
	private int seq;
	
	private int ref;
	private int step;
	private int depth;
	
	private String topic;
	private String title;
	private String writer;
	private String content;
	private String regdate;

	public ServiceDto() {
		
	}

	public ServiceDto(int seq, int ref, int step, int depth, String topic, String title, String writer, String content,
			String regdate) {
		super();
		this.seq = seq;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
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
	
	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
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
		return "ServiceDto [seq=" + seq + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", topic=" + topic
				+ ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
