package uniandes.mapRed;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	private static final Log log = LogFactory.getLog(WCReducer.class);

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context)
			throws IOException, InterruptedException {
		log.info("Add text: " + key);
		int tot=0;
		for(IntWritable iw:values){
			tot+=iw.get();
		}
		log.info("Key: " + key + " Total : " + tot);
		context.write(key, new IntWritable(tot));
	}

}
