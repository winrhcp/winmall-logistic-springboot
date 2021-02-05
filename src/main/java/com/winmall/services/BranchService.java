package com.winmall.services;

import com.winmall.entity.Branches;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

//CRUD Operation
@Service
public class BranchService {
    public static final String COL_NAME="users";

    public String saveBranchDetails(Branches branch) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(branch.getBname()).set(branch);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Branches getBranchDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Branches branch = null;

        if(document.exists()) {
            branch = document.toObject(Branches.class);
            return branch;
        }else {
            return null;
        }
    }

    public String updateBranchDetails(Branches branch) throws InterruptedException, ExecutionException {
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
