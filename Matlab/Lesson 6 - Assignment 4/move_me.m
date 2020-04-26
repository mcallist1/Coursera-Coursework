function w = move_me(v,a)
    
    if ~exist('a','var')
        a=0;
    end
    
    a_removed = v(v~=a);
    a_subset = v(v==a);
    
    w = horzcat(a_removed,a_subset);
    
end