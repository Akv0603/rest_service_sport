DROP TABLE IF EXISTS public.teams;
CREATE TABLE public.teams
(
    id serial NOT NULL ,
    name character varying(60) COLLATE pg_catalog."default" NOT NULL,
    sport_type character varying(60) COLLATE pg_catalog."default" NOT NULL ,
    creation_date date NOT NULL,
    CONSTRAINT teams_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.teams
    OWNER to root;