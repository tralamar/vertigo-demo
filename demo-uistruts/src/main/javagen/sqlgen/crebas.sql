-- ============================================================
--   Nom de SGBD      :  PostgreSql                     
--   Date de création :  5 févr. 2015  18:56:09                     
-- ============================================================

-- ============================================================
--   Drop                                       
-- ============================================================

drop table UTI_ROL cascade;

drop table ACTIF_CHOICE cascade;

drop table ADRESSE_SELECTION cascade;

drop table CLIENT cascade;

drop table CLIENT_CRITERE cascade;

drop table CODE_POSTAL cascade;

drop table COMMANDE cascade;

drop table COMMUNE cascade;

drop table DEPARTEMENT cascade;

drop table FAMILLE cascade;

drop table KX_FILE_INFO cascade;

drop table LIGNE_COMMANDE cascade;

drop table LOGIN cascade;

drop table OUI_NON_CHOICE cascade;

drop table PRODUIT cascade;

drop table PRODUIT_CRITERE cascade;

drop table REFERENTIEL_CHOICE cascade;

drop table REFERENTIEL_CRITERE cascade;

drop table REGION cascade;

drop table ROLE cascade;

drop table ROLE_INPUT cascade;

drop table TUTO_OBJECT cascade;

drop table TUTO_OBJECT_ETAT cascade;

drop table TUTO_OBJECT_TYPE cascade;

drop table UTILISATEUR cascade;

drop table UTILISATEUR_CRITERE cascade;

drop table UTILISATEUR_LOGIN cascade;

drop table VILLE cascade;



-- ============================================================
--   Sequences                                      
-- ============================================================
create sequence SEQ_CLIENT
	start with 1000 cache 20; 

create sequence SEQ_CODE_POSTAL
	start with 1000 cache 20; 

create sequence SEQ_COMMANDE
	start with 1000 cache 20; 

create sequence SEQ_COMMUNE
	start with 1000 cache 20; 

create sequence SEQ_DEPARTEMENT
	start with 1000 cache 20; 

create sequence SEQ_FAMILLE
	start with 1000 cache 20; 

create sequence SEQ_KX_FILE_INFO
	start with 1000 cache 20; 

create sequence SEQ_LIGNE_COMMANDE
	start with 1000 cache 20; 

create sequence SEQ_LOGIN
	start with 1000 cache 20; 

create sequence SEQ_PRODUIT
	start with 1000 cache 20; 

create sequence SEQ_REFERENTIEL_CHOICE
	start with 1000 cache 20; 

create sequence SEQ_REGION
	start with 1000 cache 20; 

create sequence SEQ_ROLE
	start with 1000 cache 20; 

create sequence SEQ_TUTO_OBJECT
	start with 1000 cache 20; 

create sequence SEQ_TUTO_OBJECT_ETAT
	start with 1000 cache 20; 

create sequence SEQ_TUTO_OBJECT_TYPE
	start with 1000 cache 20; 

create sequence SEQ_UTILISATEUR
	start with 1000 cache 20; 

create sequence SEQ_VILLE
	start with 1000 cache 20; 


-- ============================================================
--   Table : CLIENT                                        
-- ============================================================
create table CLIENT
(
    CLI_ID      	 BIGINT      	not null,
    NOM         	 VARCHAR(100)	not null,
    PRENOM      	 VARCHAR(100)	not null,
    ADDRESS     	 TEXT        	not null,
    CPO_ID      	 BIGINT      	not null,
    constraint PK_CLIENT primary key (CLI_ID)
);

comment on column CLIENT.CLI_ID is
'CLI ID';

comment on column CLIENT.NOM is
'NOM';

comment on column CLIENT.PRENOM is
'PRENOM';

comment on column CLIENT.ADDRESS is
'ADDRESS';

comment on column CLIENT.CPO_ID is
'CodePostal';

create index CLIENT_CPO_ID_FK on CLIENT (CPO_ID asc);
-- ============================================================
--   Table : CODE_POSTAL                                        
-- ============================================================
create table CODE_POSTAL
(
    CPO_ID      	 BIGINT      	not null,
    CODE_POSTAL 	 VARCHAR(5)  	not null,
    VIL_ID      	 BIGINT      	not null,
    constraint PK_CODE_POSTAL primary key (CPO_ID)
);

comment on column CODE_POSTAL.CPO_ID is
'CPO_ID';

comment on column CODE_POSTAL.CODE_POSTAL is
'CODE POSTAL';

comment on column CODE_POSTAL.VIL_ID is
'Ville';

create index CODE_POSTAL_VIL_ID_FK on CODE_POSTAL (VIL_ID asc);
-- ============================================================
--   Table : COMMANDE                                        
-- ============================================================
create table COMMANDE
(
    COM_ID      	 BIGINT      	not null,
    CODE        	 VARCHAR(30) 	not null,
    DATE_CREATION	 DATE        	not null,
    DATE_VALIDATION	 DATE        	,
    MONTANT_TOTAL	 NUMERIC(12,2)	,
    CLI_ID      	 BIGINT      	not null,
    constraint PK_COMMANDE primary key (COM_ID)
);

comment on column COMMANDE.COM_ID is
'COM ID';

comment on column COMMANDE.CODE is
'CODE';

comment on column COMMANDE.DATE_CREATION is
'DATE CREATION';

comment on column COMMANDE.DATE_VALIDATION is
'DATE VALIDATION';

comment on column COMMANDE.MONTANT_TOTAL is
'MONTANT TOTAL';

comment on column COMMANDE.CLI_ID is
'Client';

create index COMMANDE_CLI_ID_FK on COMMANDE (CLI_ID asc);
-- ============================================================
--   Table : COMMUNE                                        
-- ============================================================
create table COMMUNE
(
    ID_INSEE    	 BIGINT      	not null,
    CODE_POSTAL 	 VARCHAR(5)  	not null,
    COMMUNE     	 VARCHAR(100)	not null,
    DEPARTEMENT 	 VARCHAR(100)	not null,
    constraint PK_COMMUNE primary key (ID_INSEE)
);

comment on column COMMUNE.ID_INSEE is
'ID INSEE';

comment on column COMMUNE.CODE_POSTAL is
'Code postal';

comment on column COMMUNE.COMMUNE is
'Commune';

comment on column COMMUNE.DEPARTEMENT is
'Dï¿½partement';

-- ============================================================
--   Table : DEPARTEMENT                                        
-- ============================================================
create table DEPARTEMENT
(
    DEP_ID      	 BIGINT      	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    REG_ID      	 BIGINT      	not null,
    constraint PK_DEPARTEMENT primary key (DEP_ID)
);

comment on column DEPARTEMENT.DEP_ID is
'DEP_ID';

comment on column DEPARTEMENT.LIBELLE is
'LIBELLE';

comment on column DEPARTEMENT.REG_ID is
'Region';

create index DEPARTEMENT_REG_ID_FK on DEPARTEMENT (REG_ID asc);
-- ============================================================
--   Table : FAMILLE                                        
-- ============================================================
create table FAMILLE
(
    FAM_ID      	 BIGINT      	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    constraint PK_FAMILLE primary key (FAM_ID)
);

comment on column FAMILLE.FAM_ID is
'FAM_ID';

comment on column FAMILLE.LIBELLE is
'LIBELLE';

-- ============================================================
--   Table : KX_FILE_INFO                                        
-- ============================================================
create table KX_FILE_INFO
(
    FIL_ID      	 BIGINT      	not null,
    FILE_NAME   	 VARCHAR(30) 	not null,
    MIME_TYPE   	 VARCHAR(30) 	not null,
    LENGTH      	 BIGINT      	not null,
    LAST_MODIFIED	 DATE        	not null,
    FILE_DATA   	 VARCHAR(30) 	,
    constraint PK_KX_FILE_INFO primary key (FIL_ID)
);

comment on column KX_FILE_INFO.FIL_ID is
'Identifiant';

comment on column KX_FILE_INFO.FILE_NAME is
'Nom';

comment on column KX_FILE_INFO.MIME_TYPE is
'Type mime';

comment on column KX_FILE_INFO.LENGTH is
'Taille';

comment on column KX_FILE_INFO.LAST_MODIFIED is
'Date de derniï¿½re modification';

comment on column KX_FILE_INFO.FILE_DATA is
'data';

-- ============================================================
--   Table : LIGNE_COMMANDE                                        
-- ============================================================
create table LIGNE_COMMANDE
(
    LCO_ID      	 BIGINT      	not null,
    QUANTITE    	 BIGINT      	not null,
    COM_ID      	 BIGINT      	not null,
    PRD_ID      	 BIGINT      	not null,
    constraint PK_LIGNE_COMMANDE primary key (LCO_ID)
);

comment on column LIGNE_COMMANDE.LCO_ID is
'LCO ID';

comment on column LIGNE_COMMANDE.QUANTITE is
'QUANTITE';

comment on column LIGNE_COMMANDE.COM_ID is
'Commande';

create index LIGNE_COMMANDE_COM_ID_FK on LIGNE_COMMANDE (COM_ID asc);
comment on column LIGNE_COMMANDE.PRD_ID is
'Produit';

create index LIGNE_COMMANDE_PRD_ID_FK on LIGNE_COMMANDE (PRD_ID asc);
-- ============================================================
--   Table : LOGIN                                        
-- ============================================================
create table LOGIN
(
    LOG_ID      	 BIGINT      	not null,
    LOGIN       	 VARCHAR(30) 	not null,
    PASSWORD    	 VARCHAR(30) 	not null,
    UTI_ID      	 BIGINT      	not null,
    constraint PK_LOGIN primary key (LOG_ID)
);

comment on column LOGIN.LOG_ID is
'LOG ID';

comment on column LOGIN.LOGIN is
'Login';

comment on column LOGIN.PASSWORD is
'Mot de passe';

comment on column LOGIN.UTI_ID is
'Utilisateur';

create index LOGIN_UTI_ID_FK on LOGIN (UTI_ID asc);
-- ============================================================
--   Table : PRODUIT                                        
-- ============================================================
create table PRODUIT
(
    PRD_ID      	 BIGINT      	not null,
    CODE        	 VARCHAR(30) 	not null,
    LIBELLE     	 VARCHAR(40) 	,
    DESCRIPTION 	 TEXT        	,
    PRIX        	 NUMERIC(12,2)	,
    SI_STOCK    	 BOOL        	,
    POIDS       	 NUMERIC(4,1)	,
    COMMENTAIRE 	 TEXT        	,
    FAM_ID      	 BIGINT      	not null,
    constraint PK_PRODUIT primary key (PRD_ID)
);

comment on column PRODUIT.PRD_ID is
'identifiant';

comment on column PRODUIT.CODE is
'Code produit';

comment on column PRODUIT.LIBELLE is
'libellé';

comment on column PRODUIT.DESCRIPTION is
'description';

comment on column PRODUIT.PRIX is
'prix unitaire';

comment on column PRODUIT.SI_STOCK is
'en stock';

comment on column PRODUIT.POIDS is
'poids unitaire';

comment on column PRODUIT.COMMENTAIRE is
'commentaire';

comment on column PRODUIT.FAM_ID is
'Famille';

create index PRODUIT_FAM_ID_FK on PRODUIT (FAM_ID asc);
-- ============================================================
--   Table : REFERENTIEL_CHOICE                                        
-- ============================================================
create table REFERENTIEL_CHOICE
(
    REFERENTIEL_NAME	 VARCHAR(100)	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    constraint PK_REFERENTIEL_CHOICE primary key (REFERENTIEL_NAME)
);

comment on column REFERENTIEL_CHOICE.REFERENTIEL_NAME is
'Rï¿½fï¿½rentiel';

comment on column REFERENTIEL_CHOICE.LIBELLE is
'Rï¿½fï¿½rentiel';

-- ============================================================
--   Table : REGION                                        
-- ============================================================
create table REGION
(
    REG_ID      	 BIGINT      	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    constraint PK_REGION primary key (REG_ID)
);

comment on column REGION.REG_ID is
'REG_ID';

comment on column REGION.LIBELLE is
'LIBELLE';

-- ============================================================
--   Table : ROLE                                        
-- ============================================================
create table ROLE
(
    ROL_CODE    	 VARCHAR(30) 	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    constraint PK_ROLE primary key (ROL_CODE)
);

comment on column ROLE.ROL_CODE is
'ROL_CODE';

comment on column ROLE.LIBELLE is
'Libellé';

-- ============================================================
--   Table : TUTO_OBJECT                                        
-- ============================================================
create table TUTO_OBJECT
(
    OBJ_ID      	 BIGINT      	not null,
    CODE        	 VARCHAR(30) 	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    DESCRIPTION 	 TEXT        	,
    PRIX        	 NUMERIC(12,2)	,
    SI_STOCK    	 BOOL        	not null,
    POIDS       	 NUMERIC(4,1)	not null,
    DATE_CREATION	 DATE        	not null,
    DATE_MODIFICATION	 DATE        	,
    TYP_ID      	 BIGINT      	,
    ETA_ID      	 BIGINT      	,
    constraint PK_TUTO_OBJECT primary key (OBJ_ID)
);

comment on column TUTO_OBJECT.OBJ_ID is
'ID Objet';

comment on column TUTO_OBJECT.CODE is
'Code produit';

comment on column TUTO_OBJECT.LIBELLE is
'Libellï¿½';

comment on column TUTO_OBJECT.DESCRIPTION is
'Description';

comment on column TUTO_OBJECT.PRIX is
'Prix unitaire';

comment on column TUTO_OBJECT.SI_STOCK is
'En stock';

comment on column TUTO_OBJECT.POIDS is
'Poids unitaire';

comment on column TUTO_OBJECT.DATE_CREATION is
'Date de crï¿½ation';

comment on column TUTO_OBJECT.DATE_MODIFICATION is
'Date de modification';

comment on column TUTO_OBJECT.TYP_ID is
'type';

create index TUTO_OBJECT_TYP_ID_FK on TUTO_OBJECT (TYP_ID asc);
comment on column TUTO_OBJECT.ETA_ID is
'etat';

create index TUTO_OBJECT_ETA_ID_FK on TUTO_OBJECT (ETA_ID asc);
-- ============================================================
--   Table : TUTO_OBJECT_ETAT                                        
-- ============================================================
create table TUTO_OBJECT_ETAT
(
    ETA_ID      	 BIGINT      	not null,
    ETAT        	 VARCHAR(30) 	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    constraint PK_TUTO_OBJECT_ETAT primary key (ETA_ID)
);

comment on column TUTO_OBJECT_ETAT.ETA_ID is
'ID etat';

comment on column TUTO_OBJECT_ETAT.ETAT is
'Code Etat';

comment on column TUTO_OBJECT_ETAT.LIBELLE is
'Libellï¿½';

-- ============================================================
--   Table : TUTO_OBJECT_TYPE                                        
-- ============================================================
create table TUTO_OBJECT_TYPE
(
    TYP_ID      	 BIGINT      	not null,
    CODE        	 VARCHAR(30) 	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    constraint PK_TUTO_OBJECT_TYPE primary key (TYP_ID)
);

comment on column TUTO_OBJECT_TYPE.TYP_ID is
'ID Type';

comment on column TUTO_OBJECT_TYPE.CODE is
'Code type';

comment on column TUTO_OBJECT_TYPE.LIBELLE is
'Libellï¿½';

-- ============================================================
--   Table : UTILISATEUR                                        
-- ============================================================
create table UTILISATEUR
(
    UTI_ID      	 BIGINT      	not null,
    NOM         	 VARCHAR(100)	not null,
    PRENOM      	 VARCHAR(100)	not null,
    MAIL        	 VARCHAR(255)	not null,
    TELEPHONE   	 VARCHAR(20) 	,
    FAX         	 VARCHAR(20) 	,
    SI_ACTIF    	 BOOL        	not null,
    DATE_CREATION	 DATE        	not null,
    DATE_DERNIERE_MODIF	 DATE        	,
    AUTEUR_DERNIERE_MODIF	 VARCHAR(250)	not null,
    constraint PK_UTILISATEUR primary key (UTI_ID)
);

comment on column UTILISATEUR.UTI_ID is
'UTI_ID';

comment on column UTILISATEUR.NOM is
'Nom';

comment on column UTILISATEUR.PRENOM is
'Prénom';

comment on column UTILISATEUR.MAIL is
'Courriel';

comment on column UTILISATEUR.TELEPHONE is
'Téléphone';

comment on column UTILISATEUR.FAX is
'Fax';

comment on column UTILISATEUR.SI_ACTIF is
'Si actif';

comment on column UTILISATEUR.DATE_CREATION is
'Date de création';

comment on column UTILISATEUR.DATE_DERNIERE_MODIF is
'Date de dernière modification';

comment on column UTILISATEUR.AUTEUR_DERNIERE_MODIF is
'Auteur de dernière modification';

-- ============================================================
--   Table : VILLE                                        
-- ============================================================
create table VILLE
(
    VIL_ID      	 BIGINT      	not null,
    LIBELLE     	 VARCHAR(100)	not null,
    DEP_ID      	 BIGINT      	not null,
    constraint PK_VILLE primary key (VIL_ID)
);

comment on column VILLE.VIL_ID is
'VIL_ID';

comment on column VILLE.LIBELLE is
'LIBELLE';

comment on column VILLE.DEP_ID is
'Departement';

create index VILLE_DEP_ID_FK on VILLE (DEP_ID asc);

alter table COMMANDE
	add constraint FK_CLI_COM foreign key (CLI_ID)
	references CLIENT (CLI_ID);

alter table CLIENT
	add constraint FK_CLI_CPO foreign key (CPO_ID)
	references CODE_POSTAL (CPO_ID);

alter table CODE_POSTAL
	add constraint FK_CPO_VIL foreign key (VIL_ID)
	references VILLE (VIL_ID);

alter table VILLE
	add constraint FK_DEP_VIL foreign key (DEP_ID)
	references DEPARTEMENT (DEP_ID);

alter table LIGNE_COMMANDE
	add constraint FK_LCO_CMD foreign key (COM_ID)
	references COMMANDE (COM_ID);

alter table LIGNE_COMMANDE
	add constraint FK_LCO_PRD foreign key (PRD_ID)
	references PRODUIT (PRD_ID);

alter table TUTO_OBJECT
	add constraint FK_OBJ_ETA foreign key (ETA_ID)
	references TUTO_OBJECT_ETAT (ETA_ID);

alter table TUTO_OBJECT
	add constraint FK_OBJ_TYP foreign key (TYP_ID)
	references TUTO_OBJECT_TYPE (TYP_ID);

alter table PRODUIT
	add constraint FK_PRD_FAM foreign key (FAM_ID)
	references FAMILLE (FAM_ID);

alter table DEPARTEMENT
	add constraint FK_REG_DEP foreign key (REG_ID)
	references REGION (REG_ID);

alter table LOGIN
	add constraint FK_UTI_LOG foreign key (UTI_ID)
	references UTILISATEUR (UTI_ID);

create table UTI_ROL
(
	UTI_ID      	 BIGINT      	 not null,
	ROL_CODE    	 VARCHAR(30) 	 not null,
	constraint PK_UTI_ROL primary key (UTI_ID, ROL_CODE),
	constraint FK_UTI_ROL_UTILISATEUR 
		foreign key(UTI_ID)
		references UTILISATEUR (UTI_ID),
	constraint FK_UTI_ROL_ROLE 
		foreign key(ROL_CODE)
		references ROLE (ROL_CODE)
);

create index UTI_ROL_UTILISATEUR_FK on UTI_ROL (UTI_ID asc);

create index UTI_ROL_ROLE_FK on UTI_ROL (ROL_CODE asc);

