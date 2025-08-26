package Chapter_2_1;

import Chapter_2_1.Television;

public class TelevisionViewer {
	public static void main(String[] args) {
		Television myTV = new Television();
		myTV.setChannel(1);

		for (int day = 1; day <= 10; day++) {
			System.out.println("Woke up, day " + day);
			
			boolean tired = false;
			
			if (!myTV.isOn())
				myTV.pressOnOff();

			while (!tired) {
				System.out.println("Watching channel " + myTV.getChannel());
				int newChannel = (myTV.getChannel() + 1) % 11;
				if (newChannel == 0) {
					newChannel = 1;
				}
				myTV.setChannel(newChannel);
				if (myTV.getChannel() % 4 == 0)
					tired = true;
			}

			myTV.pressOnOff();
			
			System.out.println("Falling asleep");
		}
	}
}
