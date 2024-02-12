package d;

import java.io.IOException;

import javax.naming.Context;

import org.w3c.dom.Text;

public class WordCounterReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int sum = 0;

		for (IntWritable count : values) {
			sum += count.get();
		}
		context.write(key, new IntWritable(sum));

	}
}
