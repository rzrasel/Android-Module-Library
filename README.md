# Android-Module-Library
Android Module Library

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

### Database Metadata Table Design
**Metadata table as follows**

* MySQL Table Name: prefix_tbl_metadata

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| tmeta_id | BIGINT | 20 | ✕ |
| tmeta_tbl_identity | VARCHAR | 64 | ✓ |
| tmeta_key | VARCHAR | 255 | ✕ |
| tmeta_value | TEXT | 64 | ✓ |
| tmeta_create_date | DATETIME |  | ✕ |
| tmeta_modify_date | DATETIME |  | ✕ |
| tmeta_created_by | BIGINT | 20 | ✓ |
| tmeta_modified_by | BIGINT | 20 | ✓ |


* Drop Table

```drop_metadata_table
DROP TABLE IF EXISTS prefix_tbl_metadata;
```

* Create Table

```create_metadata_table
CREATE TABLE IF NOT EXISTS prefix_tbl_metadata (
    tmeta_id                BIGINT(20)   NOT NULL,
    tmeta_tbl_identity      VARCHAR(64) NULL,
    tmeta_key               VARCHAR(255)    NOT NULL,
    tmeta_value TEXT,
    tmeta_create_date       DATETIME     NOT NULL,
    tmeta_modify_date       DATETIME     NOT NULL,
    tmeta_created_by        BIGINT(20)  NULL,
    tmeta_modified_by       BIGINT(20)  NULL,
    CONSTRAINT pk_metadata_tmeta_id PRIMARY KEY (tmeta_id)
);
```

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




