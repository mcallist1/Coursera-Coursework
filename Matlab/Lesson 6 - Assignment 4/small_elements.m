function indexes = small_elements(X)
    
    my_indexes = []   
    [row,col] = size(X)
    for i= 1:col
        for j=1:row
            if X(j,i) < i * j 
               my_indexes = [my_indexes; j i]
            end
        end
    end
    
    indexes = my_indexes
    
end