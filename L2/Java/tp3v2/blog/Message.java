package tp3v2.blog;

public class Message extends AbstractPublishableItem {
	private String content;

	public Message(long publicationDate, String author, String content) {
		super(publicationDate, author);
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
}