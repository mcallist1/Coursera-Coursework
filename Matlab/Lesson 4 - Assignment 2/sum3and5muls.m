function sum_of_mults = sum3and5muls(n)
    my_threes = (3:3:n);
    my_fives = (5:5:n);
    sum_of_mults = sum(unique(horzcat(my_threes,my_fives)));
end   