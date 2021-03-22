package Evizinhotest2.controller;

import Evizinhotest2.model.Exchange;
import Evizinhotest2.model.Post;
import Evizinhotest2.service.ExchangeService;
import Evizinhotest2.service.PostService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    private static final String MSG_SUCESS_ADD = "Troca Adicionada com Sucesso!";
    private static final String MSG_SUCESS_UPDATE = "Troca Atualizada com Sucesso!";
    private static final String MSG_SUCESS_DELETE = "Excluído com sucesso!.";
    private static final String MSG_ERROR = "Error.";

    @RequestMapping(value = "/exchanges")
    public List<Exchange> getAllExchanges(Model model)
    {
        List<Exchange> exchanges = exchangeService.getAllExchanges();
        model.addAttribute("exchanges", exchanges);
        return exchanges;
    }

    @RequestMapping(value = "/exchanges/{id}")
    public Optional<Exchange> getExchange(@PathVariable Integer id) {
        return exchangeService.getExchange(id);
    }

    @RequestMapping(value = "/exchanges/form", method= RequestMethod.GET)
    public String addExchange(Model model, RedirectAttributes redirectAttributes) {
        try {
            Exchange exchange = new Exchange();
            model.addAttribute("exchange", exchange);
        }
        catch (Exception e) {
            System.out.println("Exception:: exception");
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", MSG_ERROR);
        }catch (Throwable e) {
            System.out.println("Throwable:: exception");
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", MSG_ERROR);
        }
        return "addExchange";
    }

    @RequestMapping(value = "/exchanges/register", method=RequestMethod.POST)
    public String addExchange(Exchange exchange, RedirectAttributes redirectAttributes) {
        try {
            exchangeService.addExchange(exchange);
            redirectAttributes.addFlashAttribute("success", MSG_SUCESS_ADD);
        } catch (Exception e) {
            System.out.println("Exception:: exception");
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", MSG_ERROR);
        }catch (Throwable e) {
            System.out.println("Throwable:: exception");
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", MSG_ERROR);
        }
        return "redirect:/exchanges/";
    }

    @RequestMapping(value = "/exchanges/{id}", method = RequestMethod.PUT)
    public void updateExchange(@RequestBody Exchange exchange, @PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            if (id != null) {
                exchangeService.updateExchange(id, exchange);
                redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @RequestMapping(value = "/exchanges/{id}/delete")
    public String deleteExchange(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            if (id != null) {
                exchangeService.deleteExchange(id);
                redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", MSG_ERROR);
            throw new ServiceException(e.getMessage());
        }
        return "redirect:/exchanges/";
    }

    @GetMapping("/exchanges/{id}")
    public String show(Model model, @PathVariable("id") Integer id) {
        try {
            if (id != null) {
                Exchange exchange = exchangeService.getExchange(id).get();
                model.addAttribute(" exchange",  exchange);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
        return "showExchange";
    }
}
