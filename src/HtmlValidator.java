import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> openTags = new Stack<>();

		while (!tags.isEmpty()){
			if (tags.peek().isSelfClosing()) tags.poll();
			else if (tags.peek().isOpenTag()) openTags.push(tags.poll());
			else {
				if (openTags.isEmpty()) return null;
				else if (tags.peek().matches(openTags.peek())) {
					openTags.pop();
					tags.poll();
				} else break;
			}
		}
		return openTags;
	}
	

}

