<!DOCTYPE html>
<head><title>Thomas McAllister's MD5 Cracker</title></head>
<body>
<h1>MD5 cracker</h1>
<p>This application takes an MD5 hash of a four digit
  pin and check all 10,000 possible four digit PINs
  to determine the PIN.
</p>
<pre>
Debug Output:
<?php
$goodtext = "Not found";
// If there is no parameter, this code is all skipped
if ( isset($_GET['md5']) ) {
    $time_pre = microtime(true);
    $md5 = $_GET['md5'];

    // This is our alphabet
    $digits = "123456789";
    $show = 15;

    for($i=0; $i<strlen($digits); $i++ ) {
        $digit1 = $digits[$i];

        for($j=0; $j<strlen($digits); $j++ ) {
            $digit2 = $digits[$j];

            for($k=0; $k<strlen($digits); $k++ ) {
                $digit3 = $digits[$k];

                for($l=0; $l<strlen($digits); $l++ ) {
                    $digit4 = $digits[$l];

            $try = $digit1.$digit2.$digit3.$digit4;

            // Run the hash and then check to see if we match
            $check = hash('md5', $try);
            if ( $check == $md5 ) {
                $goodtext = $try;
                break;   // Exit the inner loop
            }

            // Debug output until $show hits 0
            if ( $show > 0 ) {
                print "$check $try\n";
                $show = $show - 1;
            }
        }
    }

  }
}

    // Compute ellapsed time
    $time_post = microtime(true);
    print "Ellapsed time: ";
    print $time_post-$time_pre;
    print "\n";
}
?>
</pre>
<!-- Use the very short syntax and call htmlentities() -->
<p>Pin: <?= htmlentities($goodtext); ?></p>
<form>
<input type="text" name="md5" size="60" />
<input type="submit" value="Crack MD5"/>
</form>
<ul>
<li><a href="index.php">Reset</a></li>
<li><a href="md5.php">MD5 Encoder</a></li>
<li><a href="makecode.php">MD5 Code Maker</a></li>
</ul>
</body>
</html>