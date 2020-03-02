package uniandes.challenges;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class MoreFrequentlyInTitleMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private static final Log log = LogFactory.getLog(MoreFrequentlyInTitleMapper.class);

	private	final static IntWritable one = new IntWritable(1);

	private	Text word =	new	Text();
	/*
	private HashMap<String, Long> map;

	private TreeMap<Long, String> mapValues;

	@Override
	public void setup(Context context)
	{
		map = new HashMap<>();
		mapValues = new TreeMap<>();
	}
	 */

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		log.info("Text value : " + value);
		String	line = value.toString();
		StringTokenizer st = new StringTokenizer(line);
		while (st.hasMoreTokens()) {
			word.set(st.nextToken());
			context.write(word, one);
		}
		/*
		List<String> words = FilterText.getClearText(Expressions.REGEX_TITLE, value.toString(), 7,8);
		List<String> filtered = words.stream().parallel().
				filter( word -> !word.matches(Expressions.EXCLUDE_CHARACTERS)).
				collect(Collectors.toList());
		 */
	}

	/*
	@Override
	public void cleanup(Context context) throws IOException, InterruptedException
	{
		for (Map.Entry<String, Long> entry : map.entrySet())
		{
			mapValues.put(entry.getValue(), entry.getKey());
			if (mapValues.size() > 10) {
				mapValues.remove(mapValues.firstKey());
			}
		}
		for (Map.Entry<Long, String> entry : mapValues.entrySet())
		{
			Long count = entry.getKey();
			String name = entry.getValue();
			context.write(new Text(name), new IntWritable(count.intValue()));
		}
	}
	*/

	/*
	private void putValuesInMap(String word)
	{
		map.put(word, map.containsKey(word) ? (map.get(word)+1) :1);
	}
	 */

}
