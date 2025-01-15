package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {
	final List<Integer> values;

	public LogicsImpl(int size) {

			this.values = new ArrayList<>(Collections.nCopies(size, 0));
		
	}

	@Override
	public int size() {
		return this.values.size();

	}

	@Override
	public List<Integer> values() {
		return Collections.unmodifiableList(values);
	}

	@Override
	public List<Boolean> enablings() {
		return this.values.stream().map(v -> v < values.size()).toList();
	}

	@Override
	public int hit(int elem) {
		int tmp = this.values.get(elem);
		this.values.set(elem, ++tmp);
		return tmp;
	}

	@Override
	public String result() {
		return this.values.stream().map(v -> Integer.toString(v)).collect(Collectors.joining("|", "<<", ">>"));
	
	}

	@Override
	public boolean toQuit() {
		return this.values.stream().allMatch(v -> v == this.values.get(0));


	}
}
