package org.example.repositorys;

import org.example.entitys.CommercialInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommercialInvoiceRepository extends JpaRepository<CommercialInvoice, Long> {

}
