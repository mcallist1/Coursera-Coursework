function even = even_index(M)
	rows = M(2:2:end,:);
	even = rows(:, 2:2:end);