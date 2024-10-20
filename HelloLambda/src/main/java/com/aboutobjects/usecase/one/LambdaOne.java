package com.aboutobjects.usecase.one;

import java.util.Optional;
import java.util.List;
import java.util.stream.Stream;

public class LambdaOne {

    public Optional<Double> apply (String input) {      // la que yo pense.

        // step by step discover.
        //Optional<String> optional = Optional.ofNullable (input) ;
        //Optional<String[]> splited = optional.map(i->i.split("/"));
        //List<Double> myList = Stream.of(splited.get()).mapToDouble(s->Double.parseDouble(s)).boxed().toList();

        // Esto es lo que pense

        List<Double> myList =
                Stream.of   (
                        Optional.ofNullable(input)
                        .map(i->i.split("/"))
                        .get()
                )
                .mapToDouble (Double::parseDouble)
                .boxed ()
                .toList () ;
        return Optional.ofNullable (myList.get(0) / myList.get (1)) ;

    }

}
