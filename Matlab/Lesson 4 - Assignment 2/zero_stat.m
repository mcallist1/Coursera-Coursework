function percentage = zero_stat(m)
    num_of_zeros = numel(m(:)) - sum(m(:));
    percentage = (num_of_zeros/numel(m(:)))*100;
end