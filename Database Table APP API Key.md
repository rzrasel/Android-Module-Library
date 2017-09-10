### Database Table "APP API Key" Design
**"APP API Key" table as follows**

* MySQL Table Name: prefix_tbl_app_api_key

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| tap_project_id | BIGINT | 20 | ✕ |
| taak_api_id | BIGINT | 20 | ✕ |
| taak_api_key | VARCHAR | 255 | ✕ |
| taak_api_key_type | VARCHAR | 255 | ✓ |
| taak_api_usage_type | VARCHAR | 255 | ✕ |
| taak_api_status | BOOLEAN |  | ✕ |
| taak_api_create_date | DATETIME |  | ✕ |
| taak_api_modify_date | DATETIME |  | ✕ |
| taak_api_created_by | BIGINT | 20 | ✓ |
| taak_api_modified_by | BIGINT | 20 | ✓ |

* Drop Table

```drop_table_app_api_key
DROP TABLE IF EXISTS prefix_tbl_app_api_key;
```

* Create Table

```create_table_app_api_key
CREATE TABLE IF NOT EXISTS prefix_tbl_app_api_key (
    tap_project_id                  BIGINT(20)      NOT NULL,
    taak_api_id                     BIGINT(20)      NOT NULL,
    taak_api_key                    VARCHAR(255)    NOT NULL,
    taak_api_key_type               VARCHAR(255)    NOT NULL    COMMENT "Debug Or Release Type",
    taak_api_usage_type             VARCHAR(255)    NOT NULL    COMMENT "OS Type, Android, iOS, Windows Or Other",
    taak_api_status                 BOOLEAN         NOT NULL,
    taak_api_create_date            DATETIME        NOT NULL,
    taak_api_modify_date            DATETIME        NOT NULL,
    taak_api_created_by             BIGINT(20)      NULL,
    taak_api_modified_by            BIGINT(20)      NULL,
    CONSTRAINT pk_app_api_key_taak_api_id PRIMARY KEY (taak_api_id),
    CONSTRAINT uk_app_api_key_taak_api_key UNIQUE KEY (taak_api_key)
);
```

[Rz Rasel]
