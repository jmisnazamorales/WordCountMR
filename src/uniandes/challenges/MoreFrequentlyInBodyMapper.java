package uniandes.challenges;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import uniandes.constants.Expressions;
import uniandes.text.functions.FilterText;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MoreFrequentlyInBodyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        HashMap<String, Integer> wordsInLine= new HashMap<>();
        List<String> words = FilterText.getClearText(Expressions.REGEX_BODY, value.toString(), 6,7);
        words.stream().parallel().peek(String::toLowerCase)
                .filter( word -> !word.equals("")).filter(word -> !word.contains("&lt"))
                .forEach( word -> wordsInLine.put(word, wordsInLine.containsKey(word) ?
                        (wordsInLine.get(word)+1) :1) );
        /*
        wordsInLine.keySet().stream().forEach(x -> {
            try {
                System.out.println("Add text: " + x);
                context.write(new Text(x), new IntWritable(wordsInLine.get(x)));
            } catch (IOException e) {
                System.out.println("Error io : " + e.getMessage() + " in value " + x);
            } catch (InterruptedException e) {
                System.out.println("Interruption error : " + e.getMessage() + " in value " + x);
            }
        });
         */
    }

}
