package uniandes.reuters.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

import java.io.IOException;

public class JobCounter {

	private static final Log log = LogFactory.getLog(JobCounter.class);

	public static void main(String[] args)  {
		log.info("Running app");
		if(args.length<2){
			System.out.println("Se necesitan las carpetas de inputFolder y outputFolder");
			System.exit(-1);
		}
		String inputFolder = args[0]; //inputFolder registered in hdfs
		log.info("Parameter input :" + inputFolder);
		String outputFolder = args[1];//La carpeta de outputFolder no puede existir
		String caseSelection = args[2];//User case selected
		log.info("Parameter output :" + outputFolder);
		try {
			executeJob(inputFolder, outputFolder, caseSelection);
		} catch (Exception e) { //Puede ser IOException, ClassNotFoundException o InterruptedException
		    System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		
	}
	public static void executeJob(String inputFolder, String outputFolder, String jobCase)
			throws IOException,ClassNotFoundException, InterruptedException {
		/**
		 * Objeto de configuración, dependiendo de la versión de Hadoop 
		 * uno u otro es requerido. 
		 * */
		JobClient client = new JobClient();
		JobConf conf = new JobConf(JobCounter.class);

		/*
		Configuration conf = new Configuration();
		Job mainJob=Job.getInstance(conf, "Counter");
		mainJob.setJarByClass(JobCounter.class);
		//////////////////////
		//Mapper
		//////////////////////
		switch (jobCase){
			case "1":
				conf.set(XmlInputFormat.START_TAG_KEY, "<REUTERS ");
				conf.set(XmlInputFormat.END_TAG_KEY, "</REUTERS>");
				mainJob.setInputFormatClass(XmlInputFormat.class);
				mainJob.setMapperClass(MoreFrequentlyInTitleMapper.class);
				break;
			case "2":
				conf.set("xmlinput.start", Expressions.INIT_BODY);
				conf.set("xmlinput.end", Expressions.END_BODY);
				mainJob.setMapperClass(MoreFrequentlyInBodyMapper.class);
				break;
		}
		mainJob.setMapOutputKeyClass(Text.class);
		mainJob.setMapOutputValueClass(IntWritable.class);
		///////////////////////////
		//Reducer
		///////////////////////////
		mainJob.setReducerClass(WCReducer.class);
        mainJob.setNumReduceTasks(1);
		mainJob.setOutputKeyClass(Text.class);
		mainJob.setOutputValueClass(IntWritable.class);
		///////////////////////////
		//Input Format
		///////////////////////////
		//Advertencia: Hay dos clases con el mismo nombre, 
		//pero no son equivalentes. 
		//Se usa, en este caso, org.apache.hadoop.mapreduce.lib.input.TextInputFormat
		TextInputFormat.setInputPaths(mainJob, new Path(inputFolder));
		//mainJob.setInputFormatClass(TextInputFormat.class);
		////////////////////
		///Output Format
		//////////////////////
		TextOutputFormat.setOutputPath(mainJob, new Path(outputFolder));
		mainJob.setOutputFormatClass(TextOutputFormat.class);
		mainJob.waitForCompletion(true);
		System.out.println(mainJob.toString());
		 */
	}

}
