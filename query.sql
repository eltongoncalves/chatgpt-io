SELECT 
    hc.ID AS header_id,
    hc.brcrddcH0DataLote AS data_lote,
    hc.brcrddcH0NomeArquivo AS nome_arquivo,
    dc.ID AS detalhes_conta_id,
    dc.brcrddcD1Conta AS conta,
    dc.brcrddcD1Prod AS produto,
    dc.brcrddcD1Subprod AS subproduto,
    dc.brcrddcD1CpfCnpj AS cpf_cnpj,
    cp.ID AS contrato_id,
    cp.brcrddcD7Contrato AS contrato,
    cp.brcrddcD7Dtvencto AS data_vencimento,
    cp.brcrddcD7Vlramortizado AS valor_amortizado,
    cp.brcrddcD7Vlrjuros AS valor_juros,
    cp.brcrddcD7Vlrprestacao AS valor_prestacao,
    cp.brcrddcD7Saldonominal AS saldo_nominal,
    pa.brcrddcD5VlroriCompra AS valor_original_compra,
    pa.brcrddcD5SldrotCompra AS saldo_rotativo_compra,
    pa.brcrddcD5SldportCompra AS saldo_portado_compra
FROM 
    HEADER_PORTABILIDADE hc
JOIN 
    DETALHES_CONTA_PORTABILIDADE dc ON hc.ID = dc.header_id
LEFT JOIN 
    CONTRATO_PARC_FORMATADOPP_PORTABILIDADE cp ON dc.ID = cp.detalhes_conta_id
LEFT JOIN 
    PARCELAMENTO_AUTOMATICO_PORTABILIDADE pa ON dc.ID = pa.detalhes_conta_id
ORDER BY 
    hc.brcrddcH0DataLote, dc.brcrddcD1Conta;



@Query("""
    SELECT d
    FROM HeaderEntity h
    JOIN DetalhesContaEntity d ON h.id = d.header.id
    WHERE d.brcrddcD1Conta = :brcrddcD1Conta
    AND h.data = (
        SELECT MAX(h2.data) 
        FROM HeaderEntity h2
    )
""")
List<DetalhesContaEntity> findMostRecentHeaderWithDetalhesConta(@Param("brcrddcD1Conta") String brcrddcD1Conta);

