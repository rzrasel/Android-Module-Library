# Android-Module-Library
Android Module Library

- - - -

### GIT Command
```git_command
git init
git remote add origin https://github.com/rzrasel/Android-Module-Library.git
git remote -v
git fetch && git checkout master
git add .
git commit -m "Add Project"
git push --all
git pull
```

- - - -
https://github.com/tchapi/markdown-cheatsheet/blob/master/README.md
- - - -

* Bullet list
    * Nested bullet
        * Sub-nested bullet etc
* Bullet list item 2

~~~
 Markup : * Bullet list
              * Nested bullet
                  * Sub-nested bullet etc
          * Bullet list item 2
~~~

1. A numbered list
    1. A nested numbered list
    2. Which is numbered
2. Which is numbered

~~~
 Markup : 1. A numbered list
              1. A nested numbered list
              2. Which is numbered
          2. Which is numbered
~~~

- [ ] An uncompleted task
- [x] A completed task

- - - -

### Other Info

> Other Information
> That I Have Need To Store

* APP Project Table
    * Project Id
    * Project Name
    * Project Status
    - Create Date
    - Modify Date
    - Created By
    - Modified By
* APP API Key Table
    - Project Id ***Foreign Key (APP Project Table)***
    - API Key Id
    - Name
    - API Key
    - Key Type ***Release Or Debug Key***
    - Usage Type ***Android, iOS***
    - Status
    - Create Date
    - Modify Date
    - Created By
    - Modified By


####Java Sample Code for Calculating HMAC-SHA1 Signatures

[Java Sample Code for Calculating HMAC-SHA1 Signatures](https://gist.github.com/ishikawa/88599)

[Java Sample Code for Calculating HMAC-SHA1 Signatures](https://stackoverflow.com/questions/13119641/java-programmatically-read-informations-from-a-key-certificate)

[How to read SHA and MD5 fingerprint programmatically in Android](https://stackoverflow.com/questions/28251131/how-to-read-sha-and-md5-fingerprint-programmatically-in-android)

[How do I programatically extract a certificate from a site and add it to my keystore?](http://helpdesk.objects.com.au/java/how-do-i-programatically-extract-a-certificate-from-a-site-and-add-it-to-my-keystore)

```password_encode_and_check
function pw_encode($password)
{
   for ($i = 1; $i <= 10; $i++)
       $seed .= substr('0123456789abcdef', rand(0,15), 1);
   return sha1($seed.$password.$seed).$seed;
}
function pw_check($password, $stored_value)
{
   if (strlen($stored_value) != 50)
      return FALSE;
   $stored_seed = substr($stored_value,40,10);
   if (sha1($stored_seed.$password.$stored_seed).$stored_seed == $stored_value)
     return TRUE;
   else
     return FALSE;
}
echo pw_check("com.sm.cmdss", "ca564c8472c24d0b0f84baef685db9aa49e9df2ce131057fa5");
```
```password_encode_and_check
```password_encode_and_check
function HashPassword($password)
{
    $seed = "abckasdjf";
    mt_srand(microtime()*1000000);
    //$salt = mhash_keygen_s2k(MHASH_SHA1, $password, substr(pack('h*', md5(mt_rand())), 0, 8), 4);
    $salt = mhash_keygen_s2k(MHASH_SHA1, $password, substr(pack('h*', md5($seed)), 0, 8), 4);
    $hash = base64_encode(mhash(MHASH_SHA1, $password.$salt).$salt);
    return $hash;
}
echo HashPassword("com.sm.cmdss");
```
```password_encode_and_check
function ValidatePassword($password, $hash)
{
    $hash = base64_decode(substr($hash, 6));
    $original_hash = substr($hash, 0, 20);
    $salt = substr($hash, 20);
    $new_hash = mhash(MHASH_SHA1, $password . $salt);
    if (strcmp($original_hash, $new_hash) == 0)
        echo "... do something because your password is valid ...";
    else
        echo 'Unauthorized: Authorization has been refused for the credentials you provided. Please login with a valid username and password.';
}
ValidatePassword("com.sm.cmdss", "l2LVkQJXx2867wjE1aST+HN50DaxAVMd");
ValidatePassword("com.sm.cmdss", "b1zPr8y2h4Dwzjmfj5wSYqQ7JsUZdGQf");
```




