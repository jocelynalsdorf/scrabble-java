import java.io.Console;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Scrabble {
    public static void main(String[] args){
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());

        get("/detector", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/detector.vtl");

            String word = request.queryParams("word");
            Integer getScore = getScore(word);

            model.put("word", word);
            model.put("getScore", getScore(word));

            return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());


    }

    public static Integer getScore(String userWord) {
        // Integer x = 0;
        String word = userWord.toLowerCase();
        Integer total = 0;
        Map<Character, Integer> numberHash = new HashMap<Character, Integer>();
        numberHash.put('a', 1);
        numberHash.put('b', 3);
        numberHash.put('c', 3);
        numberHash.put('d', 2);
        numberHash.put('e', 1);
        numberHash.put('f', 4);
        numberHash.put('g', 2);
        numberHash.put('h', 4);
        numberHash.put('i', 1);
        numberHash.put('j', 8);
        numberHash.put('k', 5);
        numberHash.put('l', 1);
        numberHash.put('m', 3);
        numberHash.put('n', 1);
        numberHash.put('o', 1);
        numberHash.put('p', 3);
        numberHash.put('q', 10);
        numberHash.put('r', 1);
        numberHash.put('s', 1);
        numberHash.put('t', 1);
        numberHash.put('u', 1);
        numberHash.put('v', 4);
        numberHash.put('w', 4);
        numberHash.put('x', 8);
        numberHash.put('y', 4);
        numberHash.put('z', 10);
        numberHash.put(' ', 0);

        for (Integer i = 0; i < word.length(); i++) {
         total += numberHash.get(word.charAt(i));
        }

        return total;


    }

}
