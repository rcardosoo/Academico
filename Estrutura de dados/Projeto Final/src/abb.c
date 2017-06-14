#include "funcoes.h"

void abbcriar(tarv *t) {
    *t = NULL;
}

int abbinserir(tarv *t, int mat, int id) {
    if ((*t) == NULL) {
        (*t) = (tarv) malloc(sizeof(tno));
        (*t)->esq = (*t)->dir = NULL;
        (*t)->matricula = mat;
        (*t)->indice = id;
        return 0;
    } else {
        if ((*t)->matricula > mat) {
            return abbinserir(&((*t)->esq), mat, id);
        } else if ((*t)->matricula < mat) {
            return abbinserir(&((*t)->dir), mat, id);
        }
    }
    return 1;
}

int abbbuscar(tarv t, int mat) {
    if (t == NULL) return -1;
    if (t->matricula == mat) {
        return t->indice;
    }
    if (t->matricula > mat){
        return abbbuscar(t->esq,mat);
    } else if (t->matricula < mat) {
         return abbbuscar(t->dir,mat);
    }
    return 0;
}

void abbexibir(tarv t) {
    if (t == NULL) return;
    abbexibir(t->esq);
    printf("%d ", t->matricula);
    abbexibir(t->dir);
}

void abbremove(tarv *t, int mat) {
    tarv p,q;
    p = *t;
    if (p == NULL) {
        printf("Não existe registro!\n");
        return;
    }else if (p->matricula > mat) {
        return abbremove(&(p->esq), mat);
    } else if (p->matricula < mat) {
        return abbremove(&(p->dir), mat);
    } else {
        if (p->esq == NULL && p->dir == NULL) {
            free(p);
            *t = NULL;
        } else if (p->esq == NULL) {
            *t = p->dir;
            free(p);
        } else if (p->dir == NULL) {
            *t = p->esq;
            free(p);
        } else if (p->dir != NULL && p->esq != NULL) {
            q = p->esq;
            while (q->dir != NULL) {
                q = q->dir;
            }
            p->matricula = q->matricula;
            p->indice = q->indice;
            q->matricula = mat;
            q->indice = 0;
            return abbremove(&(p->esq), mat);
        }
    }
}

void abbesvaziar(tarv *t) {
   if (*t == NULL) return;
     abbesvaziar(&(*t)->esq);
     abbesvaziar(&(*t)->dir);
     free(*t);
     *t = NULL;
}







