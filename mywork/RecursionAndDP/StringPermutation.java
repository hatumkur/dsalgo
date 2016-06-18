/*
*/

public void stringPermutation(String input) {
    if(input == null || input.length() == 0) return;

    int len = input.length();
    boolean[] used = new boolean[len];
    StringBuilder out = new StringBuilder();
    doPermute(input.toCharArray(), out, used, len, 0);
}

private void doPermute(char[] input, StringBuilder out, boolean[] used, int length, int level) {
	if(length == level) {
		print
		return;
	}

	for(int i = 0; i < lenght; i++) {
		if(used[i]) continue;
		out.append(input[i]);
		used[i] = true;
		doPermute(in, out, used, length, level+1);
		used[i] = false;
		out.setLength(out.length()-1);
	}
}

private void doCombine(char[] in, StringBuilder out, int length, int start, int level) {

	for(int i = start; i < length; i++) {
		out.append(in[i]);
		print
		if(i < length - 1) {
			doCombine(in, out, length, start+1, level+1);
		}
		out.setLength(out.length()-1);
	}
}
