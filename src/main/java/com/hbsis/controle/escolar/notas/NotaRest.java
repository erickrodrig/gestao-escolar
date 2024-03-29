package com.hbsis.controle.escolar.notas;

import com.hbsis.controle.escolar.alunos.Aluno;
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/notas")
public class NotaRest {
    private final NotaService notaService;

    public NotaRest(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping("/save")
    public NotaDTO save(@Valid @RequestBody NotaDTO notaDTO) {
        return notaService.save(notaDTO);
    }

    @PutMapping("/update")
    public NotaDTO update(@Valid @RequestBody NotaDTO notaDTO) {
        return notaService.update(notaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        notaService.delete(id);
    }

    @GetMapping("/{id}")
    public NotaDTO get(@PathVariable("id") Long id) {
        return NotaDTO.of(notaService.findById(id));
    }

    @GetMapping("/list")
    public List<Nota> list() {
        return notaService.findAll();
    }

    @GetMapping("/list/{id}")
    public List<Nota> listById(@PathVariable("id") Long id) {
        return notaService.findAllByAlunoId(id);
    }

    @GetMapping("/export/{idA}/bimestre/{idB}")
    public void export(@PathVariable("idA") Long alunoId, @PathVariable("idB") Long bimestreId, HttpServletResponse response) throws IOException, JRException {
        this.notaService.exportarJR(alunoId, bimestreId, response);
    }
}
