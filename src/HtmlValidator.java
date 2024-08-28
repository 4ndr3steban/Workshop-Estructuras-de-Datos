import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> openTags = new Stack<>();
		int tagsLenght = tags.size();
		
		tags.stream()
				.filter(HtmlTag::isOpenTag)
				.forEach(openTags::push);
		
		for (int i = 0; i < tagsLenght; i++) {
			if (tags.peek().isOpenTag()) tags.poll();
			else if (tags.peek().isSelfClosing()) tags.poll();
			else if (!tags.peek().isOpenTag() && tags.peek().matches(openTags.peek())) {
				tags.poll();
				openTags.pop();
			} else if (!tags.peek().isOpenTag() && !tags.peek().matches(openTags.peek())) break;
		}

		if (!tags.isEmpty()) {
			return null;
		}
		return openTags; // this line is here only so this code will compile if you don't modify it
	}
	

}

