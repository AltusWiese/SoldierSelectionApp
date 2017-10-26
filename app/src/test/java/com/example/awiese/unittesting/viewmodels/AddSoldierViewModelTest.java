package com.example.awiese.unittesting.viewmodels;

import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class AddSoldierViewModelTest {

    @Mock
    private SoldierRepository soldierRepository;

    @Captor
    private ArgumentCaptor<SoldierRepository.SoldierRepositoryCallback> soldierRepositoryCallbackArgumentCaptor = ArgumentCaptor.forClass(SoldierRepository.SoldierRepositoryCallback.class);

    private AddSoldierViewModel addSoldierViewModel;

    private static final String soldierName = "Dennis";
    private static final String soldierAlias = "OscarMike";
    private static final String soldierNationality = "Spanish";
    private static final String soldierUnitClass = "Sniper";
    private static final int soldierAim = 65;
    private static final int soldierSpeed = 58;
    private static final int soldierWill = 42;
    private static final int soldierDefense = 78;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        addSoldierViewModel = new AddSoldierViewModel(soldierRepository);
    }

    @Test
    public void addNewSoldier_DatabaseWorks_AddToDbSuccess() {

        addSoldierViewModel.addNewSoldier(soldierName, soldierAlias, soldierNationality, soldierUnitClass, soldierAim, soldierSpeed, soldierWill, soldierDefense);
        verify(soldierRepository).addSoldier(any(SoldierUnitModel.class), soldierRepositoryCallbackArgumentCaptor.capture());
        soldierRepositoryCallbackArgumentCaptor.getValue().onSuccess();
        assertEquals(true, addSoldierViewModel.addSoldierEvent.getValue());
    }

    @Test
    public void addNewSoldier_DatabaseWorks_AddToDbFailed() {
        addSoldierViewModel.addNewSoldier(soldierName, soldierAlias, soldierNationality, soldierUnitClass, soldierAim, soldierSpeed, soldierWill, soldierDefense);
        verify(soldierRepository).addSoldier(any(SoldierUnitModel.class), soldierRepositoryCallbackArgumentCaptor.capture());
        soldierRepositoryCallbackArgumentCaptor.getValue().onError();
        assertEquals(false, addSoldierViewModel.addSoldierEvent.getValue());
    }


}

