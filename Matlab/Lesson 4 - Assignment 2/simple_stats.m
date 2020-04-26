function S = simple_stats(N)

    my_mean = mean(N,2);
    my_median = median(N,2);
    my_min = min(N,[],2);
    my_max = max(N,[],2);
    
    S = horzcat(my_mean,my_median,my_min,my_max);
    
end