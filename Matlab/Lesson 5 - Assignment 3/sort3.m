function [s, m, l] = sort3(v)
    
    if(v(1)<=v(2) && v(2)<=v(3))
        s=v(1);
        m=v(2);
        l=v(3);
    elseif(v(1)<=v(3) && v(3)<=v(2))
        s=v(1);
        m=v(3);
        l=v(2);
    elseif(v(2)<=v(3) && v(3)<=v(1))
        s=v(2);
        m=v(3);
        l=v(1);
    elseif(v(2)<=v(1) && v(1)<=v(3))
        s=v(2);
        m=v(1);
        l=v(3);
    elseif(v(3)<=v(1) && v(1)<=v(2))
        s=v(3);
        m=v(1);
        l=v(2);
    elseif(v(3)<=v(2) && v(2)<=v(1))
        s=v(3);
        m=v(2);
        l=v(1);
    end      
end