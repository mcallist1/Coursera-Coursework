function [num_segs, num_poles] = fence(lng, seg)
    num_segs = ceil(lng/seg);
    num_poles = num_segs + 1;
end 