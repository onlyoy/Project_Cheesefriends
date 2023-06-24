package mul.cam.a.dto;

public class QnaDto {
	private int seq;
	private String subject;
	private String subjectCode;
	
	private int ref;
	private int step;
	private int depth;
	
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String admin;
	
	public QnaDto() {
		
	}

	public QnaDto(int seq, String subject, String subjectCode, int ref, int step, int depth, String title,
			String writer, String content, String regdate, String admin) {
		super();
		this.seq = seq;
		this.subject = subject;
		this.subjectCode = subjectCode;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.admin = admin;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "QnaDto [seq=" + seq + ", subject=" + subject + ", subjectCode=" + subjectCode + ", ref=" + ref
				+ ", step=" + step + ", depth=" + depth + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", regdate=" + regdate + ", admin=" + admin + "]";
	}
	
	
}
