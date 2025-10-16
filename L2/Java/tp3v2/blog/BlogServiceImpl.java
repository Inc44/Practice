package tp3v2.blog;

import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {
	private String title;
	private List<Publishable> items;

	public BlogServiceImpl(String title) {
		this.title = title;
		this.items = new ArrayList<>();
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public void post(Publishable item) {
		this.items.add(item);
	}

	@Override
	public List<Publishable> getItems() {
		return this.items;
	}

	@Override
	public int getPublishableItemsCount() {
		return this.items.size();
	}

	@Override
	public int getTaggableItemsCount() {
		int count = 0;
		for (Publishable item : this.items) {
			if (item instanceof Taggable) {
				count++;
			}
		}
		return count;
	}

	@Override
	public List<Publishable> findItemsByAuthor(String author) {
		List<Publishable> list = new ArrayList<>();
		for (Publishable item : this.items) {
			if (author.equals(item.getAuthor())) {
				list.add(item);
			}
		}
		return list;
	}

	@Override
	public Publishable getLatestItem() {
		Publishable latestItem = null;
		long latestDate = -1;
		for (Publishable item : this.items) {
			long date = item.getPublicationDate();
			if (date > latestDate) {
				latestDate = date;
				latestItem = item;
			}
		}
		return latestItem;
	}

	@Override
	public List<Publishable> findItemsByTags(String[] tags) {
		List<Publishable> list = new ArrayList<>();
		for (Publishable item : this.items) {
			if (item instanceof Taggable) {
				Taggable taggable = (Taggable) item;
				boolean matchesAll = true;
				for (String tag : tags) {
					if (!taggable.getTags().contains(tag)) {
						matchesAll = false;
						break;
					}
				}
				if (matchesAll) {
					list.add(item);
				}
			}
		}
		return list;
	}

	@Override
	public List<Publishable> findItemsByContent(String[] words) {
		List<Publishable> list = new ArrayList<>();
		for (Publishable item : this.items) {
			if (item instanceof Message) {
				Message message = (Message) item;
				boolean matchesAll = true;
				for (String word : words) {
					if (!message.getContent().contains(word)) {
						matchesAll = false;
						break;
					}
				}
				if (matchesAll) {
					list.add(item);
				}
			}
		}
		return list;
	}

	@Override
	public List<Publishable> findItemsByTagsOrContent(String[] tags) {
		List<Publishable> list = new ArrayList<>();
		for (Publishable item : this.items) {
			boolean matchesTags = false;
			if (item instanceof Taggable) {
				Taggable taggable = (Taggable) item;
				boolean matchesAllTags = true;
				for (String tag : tags) {
					if (!taggable.getTags().contains(tag)) {
						matchesAllTags = false;
						break;
					}
				}
				if (matchesAllTags) {
					matchesTags = true;
				}
			}
			boolean matchesContent = false;
			if (item instanceof Message) {
				Message message = (Message) item;
				boolean matchesAllWords = true;
				for (String word : tags) {
					if (!message.getContent().contains(word)) {
						matchesAllWords = false;
						break;
					}
				}
				if (matchesAllWords) {
					matchesContent = true;
				}
			}
			if (matchesTags || matchesContent) {
				list.add(item);
			}
		}
		return list;
	}
}