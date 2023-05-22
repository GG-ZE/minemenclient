package mmc.event.impl;

import mmc.event.EventCancellable;

public class KeyEvent extends EventCancellable {

	private final int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
}
