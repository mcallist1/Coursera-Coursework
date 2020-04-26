function diag_sum = spiral_diag_sum(n)
    
    if n ~= 1
        batches=floor(n/2);
        interval=2;
        my_sum=1;
        num=3;
        
        for i = 1:batches
            for j = 1:4
                my_sum = my_sum + num;
                if j == 4
                    break;
                else
                    num = num + interval;
                end
            end
            interval= interval + 2;
            num = num + interval;
        end
        diag_sum = my_sum;
    else
        diag_sum=1;
    end    
end