class TestString1
{
	public static void main(String[] args) {
		String str1 = "Baseball";
		String str2 = "Babal";
		for(int i=0; i<str1.length(); i++)
		{
			String temp1 = str2.substring(i, str2.length());
			CharSequence s = temp1.toLowerCase();
			String temp2 = str1.toLowerCase();

			if(temp2.contains(s))
			{
				System.out.println("The Longest Substring is : "+str2.substring(i, str2.length()));
				System.exit(0);
			}
		}
	}
}