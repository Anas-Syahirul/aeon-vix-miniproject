package com.example.aeon.view.impl;

import com.example.aeon.model.DetailKaryawan;
import com.example.aeon.model.Karyawan;
import com.example.aeon.model.dto.DtoCreateKaryawan;
import com.example.aeon.model.dto.DtoUpdateKaryawan;
import com.example.aeon.repository.DetailKaryawanRepo;
import com.example.aeon.repository.KaryawanRepo;
import com.example.aeon.view.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KaryawanImpl implements KaryawanService {
    
    @Autowired
    KaryawanRepo karyawanRepo;

    @Autowired
    DetailKaryawanRepo detailKaryawanRepo;

    @Override
    public Karyawan save(DtoCreateKaryawan dtoCreateKaryawan) {
        Karyawan savedKaryawan = karyawanRepo.save(new Karyawan(dtoCreateKaryawan));
        DetailKaryawan savedDetailKaryawan = detailKaryawanRepo.save(new DetailKaryawan(savedKaryawan,
                dtoCreateKaryawan.getNik(), dtoCreateKaryawan.getNpwp()));
        return savedKaryawan;
    }

    @Override
    public Karyawan update(DtoUpdateKaryawan dtoUpdateKaryawan) {
        Karyawan foundKaryawan = karyawanRepo.findById(dtoUpdateKaryawan.getId()).orElse(new Karyawan());
        if (foundKaryawan.getNama() != null) {
//            Object[] karyawanAtribute = {
//                    dtoUpdateKaryawan.getNama(), dtoUpdateKaryawan.getJk(),
//                    dtoUpdateKaryawan.getDob(), dtoUpdateKaryawan.getAlamat(),
//                    dtoUpdateKaryawan.getStatus(), dtoUpdateKaryawan.getNik(),
//                    dtoUpdateKaryawan.getNpwp()
//            };
//            for ( Object atribut: karyawanAtribute) {
//                if (atribut != null) {
//
//                }
//            }
            foundKaryawan.setUpdatedDate(new Date());
            foundKaryawan.setNama(dtoUpdateKaryawan.getNama());
            foundKaryawan.setJk(dtoUpdateKaryawan.getJk());
            foundKaryawan.setStatus(dtoUpdateKaryawan.getStatus());
            foundKaryawan.setDob(dtoUpdateKaryawan.getDob());
            karyawanRepo.save(foundKaryawan);
            DetailKaryawan detailKaryawanByKaryawan = detailKaryawanRepo.getDetailKaryawanByKaryawan(foundKaryawan);
            detailKaryawanByKaryawan.setNik(dtoUpdateKaryawan.getNik());
            detailKaryawanByKaryawan.setNpwp(dtoUpdateKaryawan.getNpwp());
            detailKaryawanRepo.save(detailKaryawanByKaryawan);
            return foundKaryawan;
        }
        return null;
    }

    @Override
    public List<Karyawan> getAll() {
        return null;
    }

    @Override
    public Karyawan getById(Long id) {
        Karyawan karyawan = karyawanRepo.findById(id).orElse(new Karyawan());
        if (karyawan.getId() != null) {
            return karyawan;
        }
        return null;
    }

    @Override
    public Page<Karyawan> findByNama(String nama, Pageable pageable) {
        if (nama == null) {
            return karyawanRepo.getAllKaryawanList(pageable);
        }
        return karyawanRepo.getKaryawanByNama(nama, pageable);
    }
}
