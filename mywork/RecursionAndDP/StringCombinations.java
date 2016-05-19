/*
    Time : ?
    Space: ?
*/

public void stringCombinations(char[] in) {
    StringBuilder out = new StringBuilder();
    doCombine(in, out, in.length, 0, 0);
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
