#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

pthread_mutex_t lock; // Lock l;
int shared_counter = 0;

/*
 * Runnable {
 *  run () {
 *
 *  }
 * }
 *
 **/
void* run ( void *args ) {
  int *i = (int*) args;

  int tmp;
  pthread_mutex_lock(&lock); //lock.lock()
  tmp = shared_counter;
  tmp = tmp + 1;
  shared_counter = tmp;
  pthread_mutex_unlock(&lock); //lock.unlock()

  printf("hello world from thread %d!\n",*i);
  return NULL;
}

int main (int argc, char* argv[]) {
  pthread_mutex_init ( &lock, NULL); // Lock l = new Lock();

  printf("hello world from main thread\n");
  printf("How many threads ? ");
  int n; scanf("%d",&n);
  {
    pthread_t t[n];
    pthread_attr_t a;
    int i,id[n];
    printf("creating %d threads ...\n",n);
    for(i=0; i<n; i++) {
      id[i] = i;
      pthread_attr_init(&a); // Thread t = new Thread();
//      pthread_create(&t[i], &a, run, (void*)&i); // t.start()
      pthread_create(&t[i], &a, run, (void*)&id[i]); // t.start()
    }

    printf("waiting for threads to return ...\n");
    for(i=0; i<n; i++) 
      pthread_join(t[i],NULL); //t.join()
  }

  printf("a counter value is %d\n", shared_counter);

  return 0;
}
