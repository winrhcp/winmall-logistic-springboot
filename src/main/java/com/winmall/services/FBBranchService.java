package com.winmall.services;

import com.google.cloud.firestore.*;
import com.winmall.entities.FBBranches;
import com.google.api.core.ApiFuture;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

//CRUD Operation cloud firestore
@Service
public class FBBranchService {
    public static final String COL_NAME="branches";

    public FBBranches getAllBranches() throws InterruptedException, ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> apiFuture = dbFirestore.document(COL_NAME+"/fashion").get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
//        ApiFuture<QuerySnapshot> query = dbFirestore.collection(COL_NAME).get();
//        QuerySnapshot querySnapshot = query.get();
//        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        return documentSnapshot.toObject(FBBranches.class);
    }

    public String saveBranchDetails(FBBranches branch) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(branch.getBname()).set(branch);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public FBBranches getBranchDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        FBBranches branch = null;

        if(document.exists()) {
            branch = document.toObject(FBBranches.class);
            return branch;
        }else {
            return null;
        }
    }

    public String updateBranchDetails(FBBranches branch) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(branch.getBname()).set(branch);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteBranch(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Document with Branch ID "+name+" has been deleted";
    }
}
