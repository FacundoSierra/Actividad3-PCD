package d;

import java.io.IOException;

import javax.naming.Context;

import org.w3c.dom.Text;

public class WordCounterMapper extends Mapper<LongWritable, Text, Text, InWritable> {
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		if (line.contains("wallet.rest-api")) {
			if (line.contains("[INFO]")) {
				word.set("[INFO]");
				context.write(word, one);
			} else if (line.contains("[SEVERE]")) {
				word.set("[SEVERE]");
				context.write(word, one);
			} else if (line.contains("[WARN]")) {
				word.set("[WARN]");
				context.write(word, one);
			}

		}
	}
}
