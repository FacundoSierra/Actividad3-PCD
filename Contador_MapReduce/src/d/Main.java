package d;

public class Main {

	public static void main(String[] args) throws Exception {

	int res = ToolRunner.run(new Main),args);
	System.exit(res);
	}

	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(getConf(), "WordCounter");

		job.setJarByClass(this.getClass());

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(WordCounterMapper.class);
		job.SetReducerClass(WordCounterReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntwrItable.class);

		return job.waitForCompletion(true) ? 0 : 1;
	}
}
