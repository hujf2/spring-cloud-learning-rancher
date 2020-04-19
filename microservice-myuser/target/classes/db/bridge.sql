CREATE TABLE "public"."bridge_kfq_ss" (
  "geom" "public"."geometry",
  "rid" varchar(64) COLLATE "pg_catalog"."default",
  "name" varchar(64) COLLATE "pg_catalog"."default",
  "dir_4_no" varchar(10) COLLATE "pg_catalog"."default",
  "dir_8_no" varchar(10) COLLATE "pg_catalog"."default",
  "name_chn" varchar(64) COLLATE "pg_catalog"."default",
  "alias_chn" varchar(64) COLLATE "pg_catalog"."default",
  "road" int8,
  "mesh_guf" varchar(10) COLLATE "pg_catalog"."default",
  "direction" int8,
  "length" numeric,
  "road_class" int8,
  "forwardroa" varchar(64) COLLATE "pg_catalog"."default",
  "road_link_num" varchar(64) COLLATE "pg_catalog"."default",
  "id" varchar(20) COLLATE "pg_catalog"."default",
  "wkt" text COLLATE "pg_catalog"."default"
)
;

ALTER TABLE "public"."bridge_kfq_ss"
  OWNER TO "postgres";