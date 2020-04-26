function sum=halfsum(A);
   sum = 0;  
    [row,col] = size(A);
    for i= 1:row
        for j=1:col
            if (i+j)>=(row+1)  
                sum = sum + A(i,j);
            end
        end
    end